SELECT
    d.country_id,
    d.country_name,
    d.total_deaths,
    COALESCE(v.vaccination_status, 'No Data') AS vaccination_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v
ON d.country_id = v.country_id;