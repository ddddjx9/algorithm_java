-- 查找部门中工资前三高的员工信息
-- 观察问题，采用并列连续排名
select
    d.name as 'Department',
    t.name as 'Employee',
    t.salary as 'salary'
from
    (
        select
            name,
            salary,
            departmentId,
            dense_rank() over(
                partition by departmentId
                order by
                    salary desc
            ) as ranking
        from
            Employee
    ) as t,
    Department d
where
    t.ranking in (1, 2, 3)
    and t.departmentId = d.id;