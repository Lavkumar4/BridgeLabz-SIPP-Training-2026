
-- 1. CLEAN UP ENVIRONMENT (For testing)
DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS countries;

CREATE TABLE countries (
    country_name VARCHAR(100) PRIMARY KEY
);
INSERT INTO countries VALUES ('United States');

-- 2. CREATE TABLE WITH UNIQUE CONSTRAINT

CREATE TABLE covid_cases (
    -- Using an auto-incrementing ID as the Primary Key this time
    case_id INT AUTO_INCREMENT PRIMARY KEY,
    
    country VARCHAR(100) NOT NULL,
    reporting_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_covid_cases_countries FOREIGN KEY (country) REFERENCES countries(country_name),
    CONSTRAINT chk_deaths_limit CHECK (deaths <= confirmed_cases),
    
    -- Task: Create a UNIQUE constraint on the combination of Country and Date
    CONSTRAINT uq_country_date UNIQUE (country, reporting_date)
);

-- 3. TEST CASES: UNIQUENESS VALIDATION


-- Test Case A: Insert a valid record (Succeeds)
INSERT INTO covid_cases (country, reporting_date, confirmed_cases)
VALUES ('United States', '2026-07-09', 1500);

-- Test Case B: Insert a different date for the same country (Succeeds)
INSERT INTO covid_cases (country, reporting_date, confirmed_cases)
VALUES ('United States', '2026-07-10', 1600);

-- Test Case C: Attempt to insert a duplicate Country + Date combination (Fails)
-- This will be blocked because 'United States' on '2026-07-09' already exists.
INSERT INTO covid_cases (country, reporting_date, confirmed_cases)
VALUES ('United States', '2026-07-09', 1550);