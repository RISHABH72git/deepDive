import os
from datetime import datetime
import logging
import random
import time
import undetected_chromedriver as uc
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

log_filename = datetime.now().strftime("scrap_%Y-%m-%d_%H-%M-%S.log")
logging.basicConfig(level=logging.INFO,
                    format="%(asctime)s [%(levelname)s] %(name)s: %(message)s",
                    datefmt="%Y-%m-%d %H:%M:%S",  # Custom datetime format
                    handlers=[
                        logging.StreamHandler(),  # Output to console
                        logging.FileHandler(log_filename),  # Output to file
                    ])
logger = logging.getLogger(__name__)


class UTILITY:

    @staticmethod
    def get_driver():
        options = uc.ChromeOptions()
        # options.add_argument('--headless')
        options.add_argument('--disable-gpu')
        options.add_argument('--no-sandbox')
        options.add_argument('--disable-dev-shm-usage')
        options.add_argument('--incognito')
        options.add_argument('--disable-background-timer-throttling')
        options.add_argument('--disable-backgrounding-occluded-windows')
        options.add_argument('--disable-renderer-backgrounding')
        options.add_argument('--disable-blink-features=AutomationControlled')
        options.add_argument('--start-maximized')

        user_agents = [
            'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36',
            'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36',
            'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0',
            'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Safari/605.1.15',
            'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36',
            'Mozilla/5.0 (Linux; Android 4.4.2; SM-T520 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.84 Safari/537.36'
        ]

        options.add_argument(f'user-agent={random.choice(user_agents)}')
        return uc.Chrome(options=options)


class Portal:
    def __init__(self, url, timeout, user_agent, chrome_options):
        self.url = url
        self.timeout = timeout
        self.driver = UTILITY.get_driver()
        self.chrome_options = chrome_options
        self.user_agent = user_agent

    def login(self):
        l_button = self.driver.find_element(By.ID, "login_Layer")
        if l_button.is_displayed():
            l_button.click()
            time.sleep(self.timeout)
            logger.info(f"Login button pressed")
            e_field = self.driver.find_element(By.XPATH,
                                               "//input[@placeholder='Enter your active Email ID / Username']")
            if not e_field.is_displayed():
                raise Exception("Email input field is missing.")

            d = bytes.fromhex(self.user_agent).decode('utf-8')
            e_field.send_keys(d)
            p_field = self.driver.find_element(By.XPATH, "//input[@placeholder='Enter your password']")
            if not p_field.is_displayed():
                raise Exception("Password input field is missing.")

            c = bytes.fromhex(self.chrome_options).decode('utf-8')
            p_field.send_keys(c)
            # Click Login
            s_button = self.driver.find_element(By.XPATH, "//button[@class='btn-primary loginButton']")
            if not s_button.is_displayed():
                raise Exception("Login Submit button is missing.")

            s_button.click()
            logger.info(f"Login Submit button pressed")
            time.sleep(self.timeout)
        else:
            raise Exception("Login Button not Displayed")

    def logout(self):
        hamburger_menu = WebDriverWait(self.driver, self.timeout).until(
            EC.element_to_be_clickable((By.CLASS_NAME, "nI-gNb-drawer__bars")))
        hamburger_menu.click()
        time.sleep(self.timeout)
        logout_link = WebDriverWait(self.driver, self.timeout).until(EC.element_to_be_clickable(
            (By.XPATH, "//a[@title='Logout' and contains(@class, 'nI-gNb-list-cta')]")
        ))
        logout_link.click()
        time.sleep(self.timeout)

    def load_profile(self):
        p_link = WebDriverWait(self.driver, self.timeout).until(
            EC.element_to_be_clickable((By.XPATH, "//a[@href='/mnjuser/profile']")))
        if not p_link.is_displayed():
            raise Exception("Profile link is missing.")

        p_link.click()
        logger.info(f"Profile link clicked")
        time.sleep(self.timeout)

    def load_and_update_key_skills(self):
        key_skills_section = WebDriverWait(self.driver, self.timeout).until(EC.presence_of_element_located(
            (By.XPATH, "//div[contains(@class, 'widgetHead') and .//span[text()='Key skills']]")
        ))
        if not key_skills_section.is_displayed():
            raise Exception("Key skills section is missing.")

        chips = WebDriverWait(self.driver, self.timeout).until(EC.presence_of_all_elements_located(
            (By.XPATH, "//span[contains(@class, 'chip') and @title]")
        ))
        skills_titles = [chip.get_attribute("title") for chip in chips]
        if not skills_titles:
            raise Exception("No Skills found.")

        logger.info(f"Skills titles: {skills_titles}")
        skill_edit_icon = key_skills_section.find_element(By.XPATH, ".//span[contains(@class, 'edit')]")
        if not skill_edit_icon.is_displayed():
            raise Exception("Key Skill Edit icon is missing.")

        skill_edit_icon.click()
        logger.info(f"Key Skill Edit icon clicked")
        chip_div = WebDriverWait(self.driver, self.timeout).until(EC.presence_of_element_located(
            (By.XPATH, f"//div[@class='waves-effect chip' and @title='{skills_titles[0]}']")
        ))
        if not chip_div.is_displayed():
            raise Exception("Chip div is missing.")
        cross_button = chip_div.find_element(By.XPATH, ".//a[contains(@class, 'close')]")
        if not cross_button.is_displayed():
            raise Exception("Cross button is missing.")
        cross_button.click()
        logger.info(f"Cross button clicked")
        skill_input = WebDriverWait(self.driver, self.timeout).until(
            EC.presence_of_element_located((By.ID, "keySkillSugg")))
        if not skill_input.is_displayed():
            raise Exception("Skill Input is missing.")
        skill_input.clear()
        skill_input.send_keys(skills_titles[0])
        skill_input.send_keys(Keys.ENTER)

        s_button = WebDriverWait(self.driver, self.timeout).until(EC.element_to_be_clickable((By.ID, "saveKeySkills")))
        if not s_button.is_displayed():
            raise Exception("Save Keys button is missing.")

        s_button.click()
        logger.info(f"Save Keys button clicked")
        time.sleep(self.timeout)

    def clear_storage(self):
        """
        Clears local and session storage from the browser.
        """
        try:
            self.driver.delete_all_cookies()
            self.driver.execute_script("window.localStorage.clear();")
            self.driver.execute_script("window.sessionStorage.clear();")
        except Exception as e:
            logger.error("Error clearing browser storage:", e)

    def run(self):
        try:
            u = bytes.fromhex(self.url).decode('utf-8')
            self.driver.get(u)
            logger.info(f"start fetching url {self.url} ...")
            self.login()
            self.load_profile()
            self.load_and_update_key_skills()
            self.logout()
        except Exception as e:
            logger.error("Error getting page:", e)
        finally:
            logger.info(f"clearing browser storage")
            self.clear_storage()
            self.driver.quit()
            logger.info("browser closing.")


if __name__ == '__main__':
    portal_obj = Portal("url", 3,
                        "email", "pass")
    portal_obj.run()
