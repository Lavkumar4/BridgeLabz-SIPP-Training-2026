
-- 1. Table Setup Adaptation (Ensuring total_population for rate calculation)

-- Add population column if not present to calculate infection rate
-- Infection Rate = (confirmed / population) * 100


-- 2. Index Creation: Covering Index

-- A Covering Index includes all the columns specified in SELECT, WHERE, and ORDER BY.
-- By including (country, report_date, confirmed, deaths, recovered), the database engine 
-- satisfies the entire query directly from the index B-Tree without scanning base table rows.

CREATE INDEX idx_covering_top_infection 
ON covid_daily_reports (confirmed DESC, country, report_date, deaths, recovered);



-- 3. Optimized Top 10 Query Execution

-- Query to fetch the top 10 highest infection reports:
SELECT 
    country,
    report_date,
    confirmed,
    deaths,
    recovered
FROM 
    covid_daily_reports
ORDER BY 
    confirmed DESC
LIMIT 10;



-- 4. Verification & Query Execution Plan Analysis

EXPLAIN SELECT 
    country,
    report_date,
    confirmed,
    deaths,
    recovered
FROM 
    covid_daily_reports
ORDER BY 
    confirmed DESC
LIMIT 10;