-- Create Table
CREATE TABLE covid_deaths (
    death_id INT PRIMARY KEY,
    country_name VARCHAR(100),
    report_date DATE,
    new_deaths INT
);

-- Insert Sample Data
INSERT INTO covid_deaths (death_id, country_name, report_date, new_deaths) VALUES
(1, 'India', '2021-06-01', 2500),
(2, 'USA', '2021-06-01', 600),
(3, 'Brazil', '2021-06-01', 1800),
(4, 'France', '2021-06-01', 120),

(5, 'India', '2021-06-02', 2200),
(6, 'USA', '2021-06-02', 550),
(7, 'Brazil', '2021-06-02', 1700),
(8, 'France', '2021-06-02', 100),

(9, 'India', '2021-06-03', 2100),
(10, 'USA', '2021-06-03', 500),
(11, 'Brazil', '2021-06-03', 1600),
(12, 'France', '2021-06-03', 90);

-- Calculate Average New Deaths Per Day
SELECT
    report_date,
    AVG(new_deaths) AS average_new_deaths
FROM covid_deaths
GROUP BY report_date
ORDER BY report_date;