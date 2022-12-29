# jwt-sample
> 豆蔵デベロッパーサイトのブログ記事で利用しているサンプルコード

## 利用している記事
- [Auth0 java-jwtを使った素のJWT認証](https://developer.mamezou-tech.com/blogs/2022/12/10/java-jwt-auth/)

|内容| 記事の利用箇所 |
|---|---|
| [HmacJwtProvider](./jwt-producer/)| トークンの生成実装(HmacJwtProvider) |
| [HmacJwtConsumer](./jwt-consumer/)| トークンの検証実装(HmacJwtConsumer) |
| [SimpleIdProvider](./simple-idprovider/)| JWT認証の実装 |
| [AddCalculator](./add-calculator/)| JWT認証の実装 |

## ビルドと実行
サンプルアプリのビルドにはJava17以上とMavenが必要です

### リポジトリclone
```shell
# Clone this repository
git clone https://github.com/extact-io/jwt-sample.git
```

### HmacJwtProviderのビルド
```shell
# Go into HmacJwtProvider
cd jwt-sample/jwt-producer
# build application
mvn clean package
```

### HmacJwtConsumerのビルド
```shell
# Go into HmacJwtConsumer
cd jwt-sample/jwt-consumer
# build application
mvn clean package
```

### AddCalculatorのビルド
```shell
# Go into AddCalculator
cd jwt-sample/simple-idprovider
# build application
mvn clean package
```

### SimpleIdProviderのビルド
```shell
# Go into SimpleIdProvider
cd jwt-sample/add-calculator
# build application
mvn clean package
```

## 実行
[こちら](https://developer.mamezou-tech.com/blogs/2022/12/10/java-jwt-auth/)の記事を参照
