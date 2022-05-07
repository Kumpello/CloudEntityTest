# CloudEntityTest
Selenium smoke tests of CloudEntity website

Current version includes test checking if website loads and displays right name, test which checks login failure with random characters of random length (login field doesn't include @ so login should always fail), and basic test of navigation from main page to first menu item.

Tests planned in future:

1. Trying to register
  Initial conditions:
  User is not logged in, entered email is not used
  Steps:
  Fill all fields with Strings of correct length and signs, click signup button, check result
  Expected result:
  Message of email being send is displayed.

2. Logging in
  Initial conditions:
  User is not logged in
  Steps:
  Enter email and password of existing user, click sign in.
  Expected result:
  User is signed in.

3. Logging out
  Initial conditions:
  User is logged in.
  Steps:
  Sign out button is clicked.
  Expected result:
  User is not signed in anymore.
