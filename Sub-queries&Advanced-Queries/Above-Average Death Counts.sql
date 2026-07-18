SELECT 
    country, 
    death_count
FROM 
    global_health_data
WHERE 
    death_count > (
        -- Sub-query: Calculate the global average death count
        SELECT AVG(death_count) 
        FROM global_health_data
    )
ORDER BY 
    death_count DESC;