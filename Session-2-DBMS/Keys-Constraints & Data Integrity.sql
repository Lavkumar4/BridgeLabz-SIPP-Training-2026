-- 1. CLEAN UP ENVIRONMENT (For testing)
DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS countries;

CREATE TABLE countries (
    country_name VARCHAR(100) PRIMARY KEY
);
INSERT INTO countries VALUES ('India');

-- 2. CREATE TABLE WITH DEFAULT CONSTRAINTS

CREATE TABLE covid_cases (
    country VARCHAR(100) NOT NULL,
    reporting_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    deaths INT DEFAULT 0,
    
    -- Task 1: Default values for recoveries set to 0
    recovered INT DEFAULT 0,
    
    -- Task 2: Default timestamp set to current system time
    -- ON UPDATE automatically refreshes the timestamp whenever the row changes
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT pk_covid_cases PRIMARY KEY (country, reporting_date),
    CONSTRAINT fk_covid_cases_countries FOREIGN KEY (country) REFERENCES countries(country_name),
    CONSTRAINT chk_deaths_limit CHECK (deaths <= confirmed_cases)
);

-- 3. TEST CASES: VALUE AUTO-ASSIGNMENT


-- Test Case A: Omitting 'recovered' and 'last_updated'
-- We only provide country, date, confirmed, and deaths.
INSERT INTO covid_cases (country, reporting_date, confirmed_cases, deaths)
VALUES ('India', '2026-07-09', 5000, 45);

-- Test Case B: Explicitly using the DEFAULT keyword
-- This achieves the same outcome as omitting the columns entirely.
INSERT INTO covid_cases (country, reporting_date, confirmed_cases, deaths, recovered, last_updated)
VALUES ('India', '2026-07-10', 5200, 50, DEFAULT, DEFAULT);


-- 4. VERIFY AUTO-ASSIGNED VALUES

SELECT country, reporting_date, confirmed_cases, recovered, last_updated 
FROM covid_cases;