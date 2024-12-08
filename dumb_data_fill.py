import requests
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support import expected_conditions as EC
from time import sleep
import random
import sys

created = []

def create_id():
    string = 'HU-'
    for i in range(5):
        string += str(random.randrange(0,9))
    return string

driver = webdriver.Chrome()
driver.get("http://localhost:8080/")
if driver.current_url != "http://localhost:8080/login":
    driver.find_element(By.ID,"email").send_keys("admin@example.com")
    driver.find_element(By.ID,"password").send_keys("SFM2024?")
    if driver.find_element(By.TAG_NAME,"button").is_displayed():
        driver.find_element(By.TAG_NAME,"button").click()

driver.find_element(By.ID,"floatingInput").send_keys("admin@example.com")
driver.find_element(By.ID,"floatingPassword").send_keys("SFM2024?")
if driver.find_element(By.TAG_NAME,"button").is_displayed():
    driver.find_element(By.TAG_NAME,"button").click()
sleep(2)

if driver.page_source.find("nincs találat") != -1:
    driver.get("http://localhost:8080/farm-registration")
    FarmId = ['HU-12345-12345','HU-54321-54321','HU-23456-23456']
    username = ['test1@example.com','test2@example.com','test3@example.com']
    for i in range(0,len(username)):
        driver.find_element(By.ID,"floatingSelfId").send_keys(FarmId[i])
        driver.find_element(By.ID,"farmName").send_keys("Minta "+str(i))
        driver.find_element(By.ID,"zipCode").send_keys("1111")
        driver.find_element(By.ID,"settlement").send_keys("Pornóapáti")
        driver.find_element(By.ID,"street").send_keys("Minta utca")
        driver.find_element(By.ID,"streetNumber").send_keys(str(i))
        driver.find_element(By.ID,"username").send_keys(username[i])
        driver.find_element(By.ID,"password").send_keys("SFM2024?")
        sleep(2)
        if driver.find_element(By.NAME,"submit-button").is_displayed():
            driver.find_element(By.NAME,"submit-button").click()
        driver.get("http://localhost:8080/farm-registration")
    driver.get("http://localhost:8080/cattle_registration")
    i = 0
    while i < 9:
        id = create_id()
        if id in created:
            driver.get("http://localhost:8080/cattle_registration")
            continue
        created.append(id)
        driver.find_element(By.ID,"floatingSelfId").send_keys(id)
        element = driver.find_element(By.ID,"floatingSex")
        select = Select(element)
        select.select_by_value(random.choice(['true','false']))
        driver.find_element(By.ID,"floatingBirthdate").send_keys("002024-12-08")
        driver.find_element(By.ID,"floatingHoldingId").send_keys(FarmId[i % 3])
        sleep(2)
        if driver.find_element(By.NAME,"submit-button").is_displayed():
            driver.find_element(By.NAME,"submit-button").click()
        i += 1
        driver.get("http://localhost:8080/cattle_registration")
driver.get("http://localhost:8080/")
sleep(2)
if driver.find_element(By.ID,"plus_main").is_displayed:
    driver.find_element(By.ID,"plus_main").click()

driver.find_element(By.ID,"logout").click()
