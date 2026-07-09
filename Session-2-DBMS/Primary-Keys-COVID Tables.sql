-- 1. Clean up existing environment (Optional/Testing)
DROP TABLE IF EXISTS covid_cases;

-- 2. Create the table with the Composite Primary Key
CREATE TABLE covid_cases (
    country VARCHAR(100) NOT NULL,
    reporting_date DATE NOT NULL,
    confirmed_cases INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0,
    
    -- Defining Country and Date as the Composite Primary Key
    CONSTRAINT pk_covid_country_date PRIMARY KEY (country, reporting_date)
);

-- 3. Test Case: Insert valid, unique records
INSERT INTO covid_cases (country, reporting_date, confirmed_cases, deaths, recovered)
VALUES 
('Canada', '2026-03-15', 1200, 10, 800),
('Canada', '2026-03-16', 1350, 12, 900), -- Same country, different date (Allowed)
('France', '2026-03-15', 2500, 30, 1500); -- Different country, same date (Allowed)

-- 4. Test Case: Attempt to insert a duplicate record
-- This statement will FAIL and throw an error because 'Canada' on '2026-03-15' already exists.
INSERT INTO covid_cases (country, reporting_date, confirmed_cases, deaths, recovered)
VALUES ('Canada', '2026-03-15', 1250, 11, 850); 

-- 5. Verify the data
SELECT * FROM covid_cases;