-- Create Table
CREATE TABLE covid_cases (
    country_id INT PRIMARY KEY,
    country_name VARCHAR(100),
    population BIGINT,
    confirmed_cases BIGINT
);

-- Insert Sample Data
INSERT INTO covid_cases (country_id, country_name, population, confirmed_cases) VALUES
(1, 'India', 1393409038, 45000000),
(2, 'USA', 331893745, 103000000),
(3, 'Brazil', 213993437, 38000000),
(4, 'France', 67413000, 40000000),
(5, 'Russia', 145912025, 23000000);

-- Calculate Infection Rate and Rank Countries
SELECT
    country_name,
    population,
    confirmed_cases,
    ROUND((confirmed_cases * 100.0) / population, 2) AS infection_rate
FROM covid_cases
ORDER BY infection_rate DESC;