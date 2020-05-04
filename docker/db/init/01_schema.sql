drop table if exists twiiter_data.AccountHistoricalDataDaily;

create table twiiter_data.AccountHistoricalDataDaily
(
    id            int auto_increment
        primary key,
    screenName    varchar(100)           not null,
    twitterId     mediumtext             not null comment 'Twitter ID',
    followerCount int                    not null comment 'フォロワー数',
    followCount   int                    not null comment 'フォロー数',
    date          date default curdate() not null comment '記録日付'
)
    comment 'Twitterアカウントのヒストリカルデータ';
