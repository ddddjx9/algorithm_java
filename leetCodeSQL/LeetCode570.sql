-- 查询至少有5名下属的经理
-- 1. 以经理id为分组，查询超过五条的数据
select managerId, count(managerId) as total
from Employee
group by managerId
having total >= 5;
-- 2. 查询这个id对应的经理名
SELECT name
FROM Employee
WHERE id IN (SELECT managerId
             FROM Employee
             WHERE managerId IS NOT NULL
             GROUP BY managerId
             HAVING COUNT(*) >= 5);