-- 编写解决方案，报告每个奖金 少于 1000 的员工的姓名和奖金数额。
SELECT
    e.name,
    b.bonus
FROM
    Employee e
    LEFT JOIN Bonus b ON e.empId = b.empId
WHERE
    b.bonus < 1000
    OR b.bonus IS NULL;