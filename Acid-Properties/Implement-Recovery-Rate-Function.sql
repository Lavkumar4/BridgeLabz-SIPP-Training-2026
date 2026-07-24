
-- 1. Function Creation: CalculateRecoveryRate

DELIMITER //

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100),
    p_report_date DATE
) 
RETURNS DECIMAL(5,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_confirmed INT DEFAULT 0;
    DECLARE v_recovered INT DEFAULT 0;
    DECLARE v_recovery_rate DECIMAL(5,2) DEFAULT 0.00;

    -- Fetch confirmed and recovered counts for the specified country and date
    SELECT confirmed, recovered 
    INTO v_confirmed, v_recovered
    FROM covid_daily_reports
    WHERE country = p_country 
      AND report_date = p_report_date
    LIMIT 1;

    -- Avoid division by zero error if confirmed cases are 0 or record not found
    IF v_confirmed > 0 THEN
        SET v_recovery_rate = (v_recovered / CAST(v_confirmed AS DECIMAL(12,2))) * 100;
    ELSE
        SET v_recovery_rate = 0.00;
    END IF;

    RETURN v_recovery_rate;
END //

DELIMITER ;

-- 2. Verification & Usage Examples


-- Example A: Direct scalar function call for a single date
SELECT CalculateRecoveryRate('India', '2026-03-02') AS india_recovery_rate;

-- Example B: Call both rates (Mortality & Recovery) side-by-side on the view
SELECT 
    country,
    latest_report_date,
    confirmed,
    recovered,
    CalculateRecoveryRate(country, latest_report_date) AS recovery_rate_pct,
    CalculateMortalityRate(country, latest_report_date) AS mortality_rate_pct
FROM 
    vw_latest_covid_data
ORDER BY 
    recovery_rate_pct DESC;