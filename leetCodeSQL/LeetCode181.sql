-- 编写解决方案，找出收入比自己经理高的员工。
select
    e1.salary
from
    Employee e1
where
    e1.salary > (
        select
            e2.salary
        from
            Employee e2
        where
            e2.id = e1.managerId
    )