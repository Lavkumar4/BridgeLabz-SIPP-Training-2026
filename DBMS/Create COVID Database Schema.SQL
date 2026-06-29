-- Create Database
CREATE DATABASE COVID_DB;

-- Use Database
USE COVID_DB;

-- Table 1: COVID Cases
CREATE TABLE covid_cases (
    case_id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    recoveries INT,
    population BIGINT
);

-- Table 2: COVID Deaths
CREATE TABLE covid_deaths (
    death_id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    deaths INT NOT NULL
);

-- Table 3: COVID Vaccines
CREATE TABLE covid_vaccines (
    vaccine_id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    vaccine_name VARCHAR(100),
    total_vaccinations BIGINT,
    people_vaccinated BIGINT,
    people_fully_vaccinated BIGINT
);