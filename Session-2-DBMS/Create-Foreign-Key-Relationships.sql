
-- 1. CLEAN UP ENVIRONMENT (For testing)

DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS countries;
-- 2. CREATE COUNTRIES REFERENCE TABLE

CREATE TABLE countries (
    country_name VARCHAR(100) NOT NULL,
    continent VARCHAR(50),
    population BIGINT,
    -- country_name is the Primary Key that will be referenced
    CONSTRAINT pk_countries PRIMARY KEY (country_name)
);


-- 3. CREATE COVID_CASES TABLE WITH FOREIGN KEY

CREATE TABLE covid_cases (
    country VARCHAR(100) NOT NULL,
    reporting_date DATE NOT NULL,
    confirmed_cases INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0,
    
    -- Defining the Composite Primary Key (from Use Case 1)
    CONSTRAINT pk_covid_cases PRIMARY KEY (country, reporting_date),
    
    -- Defining the Foreign Key to enforce Referential Integrity
    CONSTRAINT fk_covid_cases_countries 
        FOREIGN KEY (country) 
        REFERENCES countries(country_name)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- 4. TEST CASE: POPULATING DATA


-- Step A: Insert master data into the Reference Table
INSERT INTO countries (country_name, continent, population)
VALUES 
('Japan', 'Asia', 125000000),
('Brazil', 'South America', 214000000);

-- Step B: Insert valid COVID records (Allowed)
-- 'Japan' exists in the countries table, so this succeeds.
INSERT INTO covid_cases (country, reporting_date, confirmed_cases)
VALUES ('Japan', '2026-03-15', 500);

-- Step C: Attempt to insert a record for an invalid country (Will FAIL)
-- 'Wakanda' does NOT exist in the countries table. The database will reject this.
INSERT INTO covid_cases (country, reporting_date, confirmed_cases)
VALUES ('Wakanda', '2026-03-15', 9999);