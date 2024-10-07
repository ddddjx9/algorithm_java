-- 取消率 的计算方式如下：(被司机或乘客取消的非禁止用户生成的订单数量) / (非禁止用户生成的订单总数)。
-- 编写解决方案找出 "2013-10-01" 至 "2013-10-03" 期间非禁止用户（乘客和司机都必须未被禁止）的取消率。
-- 非禁止用户即 banned 为 No 的用户，禁止用户即 banned 为 Yes 的用户。其中取消率 Cancellation Rate 需要四舍五入保留 两位小数 。
-- 按照日期分组，数状态不是completed的用户有几个
SELECT
    request_at,
    count(*)
FROM
    Trips
WHERE
    status <> 'completed'
    and client_id in (
        select
            users_id
        from
            Users
        where
            banned != 'Yes'
    )
    and driver_id in (
        select
            users_id
        from
            Users
        where
            banned != 'Yes'
    )
group by
    request_at;

-- 找出非禁止用户生成的订单总数（看看正常用户里面有没有被ban的）
SELECT
    request_at,
    count(*)
FROM
    Trips
where
    client_id in (
        select
            users_id
        from
            Users
        where
            banned != 'Yes'
    )
    and driver_id in (
        select
            users_id
        from
            Users
        where
            banned != 'Yes'
    )
group by
    request_at;

-- 开始组合sql
SELECT 
    t2.request_at AS Day,
    ROUND(IFNULL(t1.correct, 0) / t2.total, 2) AS 'Cancellation Rate'
FROM
    (
        SELECT
            request_at,
            COUNT(*) AS correct
        FROM
            Trips
        WHERE
            status <> 'completed'
            AND client_id IN (
                SELECT users_id
                FROM Users
                WHERE banned = 'No'
            )
            AND driver_id IN (
                SELECT users_id
                FROM Users
                WHERE banned = 'No'
            )
        GROUP BY
            request_at
    ) AS t1
RIGHT JOIN
    (
        SELECT
            request_at,
            COUNT(*) AS total
        FROM
            Trips
        WHERE
            client_id IN (
                SELECT users_id
                FROM Users
                WHERE banned = 'No'
            )
            AND driver_id IN (
                SELECT users_id
                FROM Users
                WHERE banned = 'No'
            )
        GROUP BY
            request_at
        HAVING
            COUNT(*) > 0
    ) AS t2
ON t1.request_at = t2.request_at;
