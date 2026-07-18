-- Query 1: Extract and label Vaccinated Population
SELECT 
    country,
    'Vaccinated' AS population_type,
    SUM(vaccinated_count) AS population_count
FROM 
    vaccination_data
GROUP BY 
    country

UNION

-- Query 2: Extract and label Unvaccinated Population
SELECT 
    country,
    'Unvaccinated' AS population_type,
    SUM(unvaccinated_count) AS population_count
FROM 
    vaccination_data
GROUP BY 
    country
    
ORDER BY 
    country ASC, 
    population_type DESC;