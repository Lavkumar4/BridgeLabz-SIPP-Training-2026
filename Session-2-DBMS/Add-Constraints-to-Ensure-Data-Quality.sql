-- ==========================================
-- 1. CLEAN UP ENVIRONMENT (For testing)
-- ==========================================
DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS countries;

-- Create parent reference table (from Use Case 2)
CREATE TABLE countries (
    country_name VARCHAR(100) PRIMARY KEY
);
INSERT INTO countries VALUES ('Germany');


-- 2. CREATE TABLE WITH NOT NULL & CHECK CONSTRAINTS

CREATE TABLE covid_cases (
    -- Country, Date, and Confirmed Cases are strict (NOT NULL)
    country VARCHAR(100) NOT NULL,
    reporting_date DATE NOT NULL,
    confirmed_cases INT NOT NULL DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0,
    
    CONSTRAINT pk_covid_cases PRIMARY KEY (country, reporting_date),
    CONSTRAINT fk_covid_cases_countries FOREIGN KEY (country) REFERENCES countries(country_name),
    
    -- CHECK constraint: Deaths cannot exceed confirmed cases
    CONSTRAINT chk_deaths_limit CHECK (deaths <= confirmed_cases)
);


-- 3. TEST CASES: VALIDATION TESTING


-- Test Case A: Valid Data (Succeeds)
-- 100 cases, 5 deaths (5 <= 100 is TRUE)
INSERT INTO covid_cases (country, reporting_date, confirmed_cases, deaths)
VALUES ('Germany', '2026-03-15', 100, 5);


-- Test Case B: Violating NOT NULL Constraint (Fails)
-- This will fail because 'confirmed_cases' is explicitly set to NULL
INSERT INTO covid_cases (country, reporting_date, confirmed_cases, deaths)
VALUES ('Germany', '2026-03-16', NULL, 2);


-- Test Case C: Violating CHECK Constraint (Fails)
-- This will fail because 150 deaths is greater than 100 confirmed cases (150 <= 100 is FALSE)
INSERT INTO covid_cases (country, reporting_date, confirmed_cases, deaths)
VALUES ('Germany', '2026-03-17', 100, 150);