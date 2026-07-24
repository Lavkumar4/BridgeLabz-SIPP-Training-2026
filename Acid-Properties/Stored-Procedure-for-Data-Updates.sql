
-- 1. Stored Procedure: UpdateCovidStats
DELIMITER //

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_report_date DATE,
    IN p_new_confirmed INT,
    IN p_new_deaths INT,
    IN p_new_recovered INT
)
BEGIN
    -- Error Handler: Rollback transaction if any SQL exception occurs
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL; -- Re-throw error to notify the caller
    END;

    -- Step 1: Start Transaction Block
    START TRANSACTION;

        -- Step 2: Validate inputs (e.g., negative counts are invalid)
        IF p_new_confirmed < 0 OR p_new_deaths < 0 OR p_new_recovered < 0 THEN
            SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Invalid input: Case counts cannot be negative.';
        END IF;

        -- Step 3: Perform Update Operation
        UPDATE covid_daily_reports
        SET 
            confirmed = p_new_confirmed,
            deaths    = p_new_deaths,
            recovered = p_new_recovered
        WHERE 
            country = p_country 
            AND report_date = p_report_date;

        -- Step 4: Verify that a matching record was found and updated
        IF ROW_COUNT() = 0 THEN
            SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Update failed: No record found for the given country and date.';
        END IF;

    -- Step 5: Commit changes if all operations succeed
    COMMIT;
END //

DELIMITER ;


-- 2. Verification & Execution Examples


-- Example A: Valid Update (Succeeds)
CALL UpdateCovidStats('India', '2026-03-02', 40010000, 520100, 39005000);

-- Query table to verify update
SELECT * FROM covid_daily_reports 
WHERE country = 'India' AND report_date = '2026-03-02';


-- Example B: Invalid Case Counts (Fails validation, triggers ROLLBACK)
-- CALL UpdateCovidStats('India', '2026-03-02', -100, 520100, 39005000);


-- Example C: Non-existent Record (Fails lookup, triggers ROLLBACK)
-- CALL UpdateCovidStats('Germany', '2026-03-02', 5000, 100, 4800);