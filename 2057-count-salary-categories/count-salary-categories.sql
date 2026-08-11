# Write your MySQL query statement below
select 
    'Low Salary' as category,
    COUNT(if(income<20000,1,null)) as accounts_count
from accounts

union all 

select 
    'Average Salary' as category,
    COUNT(if(income>=20000 && income<=50000,1,null)) as accounts_count
from accounts

union all

select 
    'High Salary' as category,
    COUNT(if(income>50000,1,null)) as accounts_count
from accounts
