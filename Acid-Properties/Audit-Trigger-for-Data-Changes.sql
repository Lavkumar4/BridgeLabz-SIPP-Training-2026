-- 
-- 1. Table Setup: Audit Log Table to Store Historical Changes
-- 
CREATE TABLE covid_audit_log (
    audit_id INT PRIMARY KEY AUTO_INCREMENT,
    record_id INT NOT NULL,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    
    -- Track Old Values
    old_confirmed INT,
    old_deaths INT,
    old_recovered INT,
    
    -- Track New Values
    new_confirmed INT,
    new_deaths INT,
    new_recovered INT,
    
    -- Metadata
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_by VARCHAR(100) DEFAULT (CURRENT_USER())
);

-- 2. Trigger Creation: BEFORE UPDATE Trigger

DELIMITER //

CREATE TRIGGER trg_covid_before_update
BEFORE UPDATE ON covid_daily_reports
FOR EACH ROW
BEGIN
    -- Only log an entry if at least one of the numerical stats actually changed
    IF OLD.confirmed <> NEW.confirmed 
       OR OLD.deaths <> NEW.deaths 
       OR OLD.recovered <> NEW.recovered THEN
       
        INSERT INTO covid_audit_log (
            record_id,
            country,
            report_date,
            old_confirmed,
            old_deaths,
            old_recovered,
            new_confirmed,
            new_deaths,
            new_recovered
        )
        VALUES (
            OLD.id,
            OLD.country,
            OLD.report_date,
            OLD.confirmed,
            OLD.deaths,
            OLD.recovered,
            NEW.confirmed,
            NEW.deaths,
            NEW.recovered
        );
    END IF;
END //

DELIMITER ;


-- 3. Verification & Testing


-- Step 3a: Perform an update on an existing record
UPDATE covid_daily_reports
SET 
    confirmed = 40020000,
    deaths = 520150
WHERE 
    country = 'India' AND report_date = '2026-03-02';

-- Step 3b: Query the audit log table to view recorded changes
SELECT 
    audit_id,
    record_id,
    country,
    report_date,
    old_confirmed,
    new_confirmed,
    old_deaths,
    new_deaths,
    changed_at,
    changed_by
FROM 
    covid_audit_log;