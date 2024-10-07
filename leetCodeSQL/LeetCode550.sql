-- 编写解决方案，报告在首次登录的第二天再次登录的玩家的 比率，四舍五入到小数点后两位。
-- 换句话说，你需要计算从首次登录日期开始至少连续两天登录的玩家的数量，然后除以玩家总数。
-- 找出连续两天登陆的玩家数量
WITH FirstLogin AS (
    SELECT
        player_id,
        MIN(event_date) AS first_login_date
    FROM
        Activity
    GROUP BY
        player_id
),
SecondDayLogin AS (
    SELECT
        f.player_id
    FROM
        FirstLogin f
        JOIN Activity a ON f.player_id = a.player_id
        AND DATE_ADD(f.first_login_date, INTERVAL 1 DAY) = a.event_date
),
PlayerCount AS (
    SELECT
        COUNT(DISTINCT player_id) AS total_players
    FROM
        Activity
),
SecondDayLoginCount AS (
    SELECT
        COUNT(DISTINCT player_id) AS second_day_logins
    FROM
        SecondDayLogin
)
SELECT
    ROUND(
        (
            SELECT
                second_day_logins
            FROM
                SecondDayLoginCount
        ) * 1.0 / (
            SELECT
                total_players
            FROM
                PlayerCount
        ),
        2
    ) AS fraction;