
-- 1. Table Setup: Create base table for daily COVID reports
CREATE TABLE covid_daily_reports (
    id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT NOT NULL DEFAULT 0,
    deaths INT NOT NULL DEFAULT 0,
    recovered INT NOT NULL DEFAULT 0
);

-- Index to optimize window functions and join operations on latest date lookups
CREATE INDEX idx_country_date ON covid_daily_reports (country, report_date DESC);


-- 2. Mock Data: Insert sample records spanning multiple dates

INSERT INTO covid_daily_reports (country, report_date, confirmed, deaths, recovered) 
VALUES
    ('India', '2026-03-01', 40000000, 520000, 39000000),
    ('India', '2026-03-02', 40005000, 520050, 39004000), -- Latest for India
    ('USA',   '2026-03-01', 80000000, 980000, 78000000),
    ('USA',   '2026-03-02', 80010000, 980100, 78008000),
    ('USA',   '2026-03-03', 80025000, 980200, 78015000), -- Latest for USA
    ('Japan', '2026-02-28', 15000000,  30000, 14500000);  -- Latest for Japan


-- 3. View Creation: Simplify retrieval of the most recent record per country

CREATE OR REPLACE VIEW vw_latest_covid_data AS
WITH RankedCovidData AS (
    SELECT 
        country,
        report_date,
        confirmed,
        deaths,
        recovered,
        ROW_NUMBER() OVER (
            PARTITION BY country 
            ORDER BY report_date DESC
        ) AS rn
    FROM 
        covid_daily_reports
)
SELECT 
    country,
    report_date AS latest_report_date,
    confirmed,
    deaths,
    recovered
FROM 
    RankedCovidData
WHERE 
    rn = 1;


-- 4. Verification: Query the view to get latest stats

SELECT * FROM vw_latest_covid_data ORDER BY confirmed DESC;