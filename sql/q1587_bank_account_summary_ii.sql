/*
Write an SQL query to report the name and balance of users with a balance 
higher than 10000. The balance of an account is equal to the sum of the 
amounts of all transactions involving that account.
Return the result table in any order.

Users table
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| account      | int     |
| name         | varchar |
+--------------+---------+
account is the primary key for this table.
Each row of this table contains the account number of each user in the bank.
There will be no two users having the same name in the table.

Transactions table
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| trans_id      | int     |
| account       | int     |
| amount        | int     |
| transacted_on | date    |
+---------------+---------+
trans_id is the primary key for this table.
Each row of this table contains all changes made to all accounts.
amount is positive if the user received money and negative if they transferred money.
All accounts start with a balance of 0.
*/


-- Cartesian Product
SELECT name, SUM(amount) AS balance
FROM Users AS u, Transactions AS t
WHERE u.account = t.account
GROUP BY u.account
HAVING SUM(amount) > 10000

-- Left Join
SELECT name, SUM(amount) AS balance
FROM Users AS u
LEFT JOIN
Transactions AS t
ON u.account = t.account
GROUP BY u.account
HAVING SUM(amount) > 10000

-- Natural Join
SELECT name, SUM(amount) AS balance
FROM Users
NATURAL JOIN Transactions
GROUP BY account
HAVING SUM(amount) > 10000


/* 
Example
Input: 
Users table:
+------------+--------------+
| account    | name         |
+------------+--------------+
| 900001     | Alice        |
| 900002     | Bob          |
| 900003     | Charlie      |
+------------+--------------+
Transactions table:
+------------+------------+------------+---------------+
| trans_id   | account    | amount     | transacted_on |
+------------+------------+------------+---------------+
| 1          | 900001     | 7000       |  2020-08-01   |
| 2          | 900001     | 7000       |  2020-09-01   |
| 3          | 900001     | -3000      |  2020-09-02   |
| 4          | 900002     | 1000       |  2020-09-12   |
| 5          | 900003     | 6000       |  2020-08-07   |
| 6          | 900003     | 6000       |  2020-09-07   |
| 7          | 900003     | -4000      |  2020-09-11   |
+------------+------------+------------+---------------+
Output format: 
+------------+------------+
| name       | balance    |
+------------+------------+
| Alice      | 11000      |
+------------+------------+

*/