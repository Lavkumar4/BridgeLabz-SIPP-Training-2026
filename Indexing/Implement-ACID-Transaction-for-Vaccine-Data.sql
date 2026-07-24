
-- 1. Setup: Base Tables for Vaccine Inventory & Tracking


-- Table A: Tracks global vaccine distribution batches
CREATE TABLE IF NOT EXISTS vaccine_distribution (
    distribution_id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    vaccine_name VARCHAR(50) NOT NULL,
    doses_shipped INT NOT NULL CHECK (doses_shipped > 0),
    shipment_date DATE NOT NULL
);

-- Table B: Tracks regional allocation logs (depends on distribution)
CREATE TABLE IF NOT EXISTS vaccine_regional_allocations (
    allocation_id INT PRIMARY KEY AUTO_INCREMENT,
    distribution_id INT NOT NULL,
    region_name VARCHAR(100) NOT NULL,
    doses_allocated INT NOT NULL CHECK (doses_allocated > 0),
    FOREIGN KEY (distribution_id) REFERENCES vaccine_distribution(distribution_id) 
        ON DELETE CASCADE
);


-- 2. Stored Procedure: Atomic Transaction Execution

DELIMITER //

CREATE PROCEDURE InsertVaccineDataAtomically(
    IN p_country VARCHAR(100),
    IN p_vaccine_name VARCHAR(50),
    IN p_doses_shipped INT,
    IN p_shipment_date DATE,
    IN p_region_name VARCHAR(100),
    IN p_doses_allocated INT
)
BEGIN
    -- Flag to check if an error occurred during transaction
    DECLARE v_rollback BOOLEAN DEFAULT FALSE;
    
    -- Handler for any SQL exception (Syntax errors, Constraint violations, etc.)
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        SET v_rollback = TRUE;
    END;

    -- STEP 1: Begin the explicit ACID transaction
    START TRANSACTION;

    -- STEP 2: First Insertion (Main Distribution Batch)
    INSERT INTO vaccine_distribution (country, vaccine_name, doses_shipped, shipment_date)
    VALUES (p_country, p_vaccine_name, p_doses_shipped, p_shipment_date);

    -- STEP 3: Second Insertion (Regional Allocation using LAST_INSERT_ID())
    INSERT INTO vaccine_regional_allocations (distribution_id, region_name, doses_allocated)
    VALUES (LAST_INSERT_ID(), p_region_name, p_doses_allocated);

    -- STEP 4: Evaluate Atomicity Condition
    IF v_rollback THEN
        -- Rollback all operations if any statement failed
        ROLLBACK;
        SELECT 'TRANSACTION FAILED: Changes rolled back to maintain Atomicity.' AS status;
    ELSE
        -- Commit changes permanently if all statements succeeded
        COMMIT;
        SELECT 'TRANSACTION SUCCESSFUL: All records inserted committed.' AS status;
    END IF;
END //

DELIMITER ;


-- 3. Verification & Testing Scenarios


-- Scenario A: Successful Execution (Valid Doses)
-- Both records will be permanently saved.
CALL InsertVaccineDataAtomically(
    'India', 'Covaxin', 500000, '2026-03-02', 'Maharashtra', 200000
);

-- Scenario B: Failure Triggering Rollback (Invalid Allocation Doses violates CHECK constraint)
-- Second insert fails -> Entire transaction rolls back -> First insert is undone.
CALL InsertVaccineDataAtomically(
    'USA', 'Pfizer', 1000000, '2026-03-02', 'California', -50000
);


-- 4. Check Final Table State
SELECT * FROM vaccine_distribution;
SELECT * FROM vaccine_regional_allocations;