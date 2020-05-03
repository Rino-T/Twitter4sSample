# Twitter4s & Play Framework Sample Project

Twitter4s を使ったサンプルプロジェクト

## 環境

* [Play Framework](https://www.playframework.com/documentation/2.6.x/Requirements): 2.6.25
* [Twitter4s](https://github.com/DanielaSfregola/twitter4s): 6.2
* Scala: 2.11.12

Twitter4s 6.2 時点だと、Play Framework 2.7.x 以上の場合 Akka HTTP のバージョンが合わず利用できないため、Play 2.6.x を利用している

## 環境変数

Twitter API 用の各種キーは環境変数に入れる。
https://github.com/DanielaSfregola/twitter4s#usage

```bash
export TWITTER_CONSUMER_TOKEN_KEY='my-consumer-key'
export TWITTER_CONSUMER_TOKEN_SECRET='my-consumer-secret'
export TWITTER_ACCESS_TOKEN_KEY='my-access-key'
export TWITTER_ACCESS_TOKEN_SECRET='my-access-secret'
```