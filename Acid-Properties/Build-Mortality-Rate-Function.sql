
-- 1. Function Creation: CalculateMortalityRate

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_report_date DATE
) 
RETURNS DECIMAL(5,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_confirmed INT DEFAULT 0;
    DECLARE v_deaths INT DEFAULT 0;
    DECLARE v_mortality_rate DECIMAL(5,2) DEFAULT 0.00;

    -- Fetch confirmed and death counts for the specified country and date
    SELECT confirmed, deaths 
    INTO v_confirmed, v_deaths
    FROM covid_daily_reports
    WHERE country = p_country 
      AND report_date = p_report_date
    LIMIT 1;

    -- Avoid division by zero error if confirmed cases are 0 or record not found
    IF v_confirmed > 0 THEN
        SET v_mortality_rate = (v_deaths / CAST(v_confirmed AS DECIMAL(12,2))) * 100;
    ELSE
        SET v_mortality_rate = 0.00;
    END IF;

    RETURN v_mortality_rate;
END //

DELIMITER ;


-- 2. Verification & Usage Examples


-- Example A: Call function directly for a single lookup
SELECT CalculateMortalityRate('USA', '2026-03-03') AS usa_mortality_rate;

-- Example B: Call function within a query on the view created earlier
SELECT 
    country,
    latest_report_date,
    confirmed,
    deaths,
    CalculateMortalityRate(country, latest_report_date) AS mortality_rate_pct
FROM 
    vw_latest_covid_data
ORDER BY 
    mortality_rate_pct DESC;