SELECT 
    country,
    confirmed_cases
FROM 
    covid_data
WHERE 
    country IN (
        -- Sub-query: Identify countries that have crossed the 1M threshold
        SELECT country
        FROM covid_data
        GROUP BY country
        HAVING MAX(confirmed_cases) > 1000000
    );