-- 查询从不订购东西的客户
-- 查询订购了东西的客户，取反即可
select
    c1.name
from
    Customers c1,
    Orders o
where
    c1.id = o.customerId;

-- 组合相关sql语句
select
    c2.name as 'Customers'
from
    Customers c2
where
    c2.id not in (
        select
            c1.id
        from
            Customers c1,
            Orders o
        where
            c1.id = o.customerId
    );