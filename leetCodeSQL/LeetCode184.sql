-- 查找部门中工资最高的人
select
    name,
    departmentId,
    rank() over(
        partition by departmentId
        order by
            salary desc
    )
from
    Employee;

-- 组合sql，连接department表
select
    d.name,
    t.name,
    t.salary
from
    (
        select
            name,
            salary,
            departmentId,
            rank() over(partition by departmentId ord er by salary desc) as ranking
        from
            Employee
    ) as t,
    Department d
where
    t.ranking = 1
    and t.departmentId = d.id;