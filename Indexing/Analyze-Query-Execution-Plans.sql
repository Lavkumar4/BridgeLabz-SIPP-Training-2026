
-- 1. Database Setup: Base Tables


-- Table A: Daily COVID statistical reports
CREATE TABLE IF NOT EXISTS covid_daily_reports (
    id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT NOT NULL DEFAULT 0,
    deaths INT NOT NULL DEFAULT 0,
    recovered INT NOT NULL DEFAULT 0
);

-- Table B: Country metadata and demographic details
CREATE TABLE IF NOT EXISTS country_metadata (
    country_id INT PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR(100) UNIQUE NOT NULL,
    continent VARCHAR(50) NOT NULL,
    population BIGINT NOT NULL
);

-- 2. Mock Data Insertion


-- Insert sample metadata records
INSERT INTO country_metadata (country_name, continent, population)
VALUES 
    ('India', 'Asia', 1400000000),
    ('USA', 'North America', 330000000),
    ('Japan', 'Asia', 125000000),
    ('Germany', 'Europe', 83000000),
    ('Brazil', 'South America', 214000000)
ON DUPLICATE KEY UPDATE population = VALUES(population);

-- Insert sample daily report records
INSERT INTO covid_daily_reports (country, report_date, confirmed, deaths, recovered) 
VALUES
    ('India', '2026-03-01', 40000000, 520000, 39000000),
    ('India', '2026-03-02', 40005000, 520050, 39004000),
    ('USA',   '2026-03-01', 80000000, 980000, 78000000),
    ('USA',   '2026-03-02', 80010000, 980100, 78008000),
    ('Japan', '2026-03-02', 15000000,  30000, 14500000),
    ('Germany','2026-03-02', 25000000, 160000, 24000000);


-- 3. Un-optimized Execution Plan Analysis

-- Analyze the complex JOIN query before creating missing indexes
EXPLAIN 
SELECT 
    m.continent,
    c.country,
    c.report_date,
    c.confirmed,
    c.deaths,
    m.population
FROM 
    covid_daily_reports c
JOIN 
    country_metadata m ON c.country = m.country_name
WHERE 
    m.continent = 'Asia'
    AND c.report_date = '2026-03-02'
ORDER BY 
    c.confirmed DESC;


-- 4. Create Missing Indexes to Resolve Bottlenecks

-- Index 1: Optimize filtering by continent on the metadata table
CREATE INDEX idx_continent 
ON country_metadata (continent);

-- Index 2: Composite index on covid_daily_reports covering (country, report_date, confirmed)
-- Accelerates the JOIN predicate, WHERE condition, and ORDER BY clause simultaneously
CREATE INDEX idx_country_date_confirmed 
ON covid_daily_reports (country, report_date, confirmed DESC);


-- 5. Optimized Execution Plan Verification


-- Re-run EXPLAIN to verify index usage and performance improvements
EXPLAIN 
SELECT 
    m.continent,
    c.country,
    c.report_date,
    c.confirmed,
    c.deaths,
    m.population
FROM 
    covid_daily_reports c
JOIN 
    country_metadata m ON c.country = m.country_name
WHERE 
    m.continent = 'Asia'
    AND c.report_date = '2026-03-02'
ORDER BY 
    c.confirmed DESC;


-- 6. Fetch Final Query Results
SELECT 
    m.continent,
    c.country,
    c.report_date,
    c.confirmed,
    c.deaths,
    m.population
FROM 
    covid_daily_reports c
JOIN 
    country_metadata m ON c.country = m.country_name
WHERE 
    m.continent = 'Asia'
    AND c.report_date = '2026-03-02'
ORDER BY 
    c.confirmed DESC;