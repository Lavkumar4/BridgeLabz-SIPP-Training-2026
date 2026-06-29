USE COVID_DB;

UPDATE covid_cases
SET confirmed_cases = 11250000
WHERE country = 'India'
AND report_date = '2021-03-01';