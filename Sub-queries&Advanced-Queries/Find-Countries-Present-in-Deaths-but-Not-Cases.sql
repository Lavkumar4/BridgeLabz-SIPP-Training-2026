SELECT DISTINCT 
    country
FROM 
    covid_deaths
WHERE 
    country NOT IN (
        -- Sub-query: Get the list of all countries that exist in the cases table
        SELECT country 
        FROM covid_cases
        WHERE country IS NOT NULL
    );