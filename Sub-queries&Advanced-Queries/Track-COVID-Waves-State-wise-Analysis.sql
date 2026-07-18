SELECT 
    main_table.date,
    main_table.state,
    main_table.confirmed_cases,
    CASE 
        WHEN main_table.confirmed_cases = (
            -- Correlated Sub-query: Find the max cases for this state up to the current date
            SELECT MAX(sub_table.confirmed_cases)
            FROM covid_data sub_table
            WHERE sub_table.state = main_table.state
              AND sub_table.date <= main_table.date
        ) THEN 'Peak/Wave Entry'
        ELSE 'Normal/Decline'
    -- You can replace 'Maharashtra' or 'Mumbai' depending on your schema setup
    END AS wave_status
FROM 
    covid_data main_table
WHERE 
    main_table.state = 'Maharashtra' 
ORDER BY 
    main_table.date ASC;