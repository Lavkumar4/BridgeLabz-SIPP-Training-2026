
-- 1. Index Creation: Single-Column & Composite Indexes


-- Single-column index on report_date
-- Optimizes general date-range queries (e.g., date filtering across all countries)
CREATE INDEX idx_report_date 
ON covid_daily_reports (report_date);

-- Composite index on (country, report_date)
-- Optimizes queries that filter or group by country AND date simultaneously
CREATE INDEX idx_country_report_date 
ON covid_daily_reports (country, report_date);



-- 2. Verification & Performance Testing
-- Query A: Uses idx_country_report_date (Composite Index)
-- Ideal for pinpointing exact records for a specific country on a given date
EXPLAIN SELECT * FROM covid_daily_reports 
WHERE country = 'India' AND report_date = '2026-03-02';

-- Query B: Uses idx_report_date (Single Index)
-- Ideal for range scans across all countries on specific dates
EXPLAIN SELECT * FROM covid_daily_reports 
WHERE report_date BETWEEN '2026-03-01' AND '2026-03-03';



-- 3. Utility: View Existing Indexes on the Table

SHOW INDEX FROM covid_daily_reports;