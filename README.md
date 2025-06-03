# Board Application

## 민감 정보 암호화 가이드

이 프로젝트는 GitHub에 업로드할 때 데이터베이스 접속 정보와 같은 민감한 정보를 보호하기 위해 Jasypt 암호화를 사용합니다.

### 1. 암호화 방식

이 프로젝트는 [jasypt-spring-boot](https://github.com/ulisesbocchio/jasypt-spring-boot)를 사용하여 application.yml 파일의 민감한 정보를 암호화합니다. 암호화된 값은 `ENC(암호화된_값)` 형식으로 저장됩니다.

### 2. 암호화된 값 생성하기

민감한 정보를 암호화하려면 다음 단계를 따르세요:

1. `JasyptEncryptionUtil` 클래스의 `main` 메서드를 실행합니다.
2. 암호화 비밀번호를 설정합니다 (예: `your-encryption-password`를 실제 비밀번호로 변경).
3. 암호화하려는 값을 설정합니다 (DB URL, 사용자 이름, 비밀번호 등).
4. 실행 결과로 출력된 암호화된 값을 복사합니다.

```kotlin
// JasyptEncryptionUtil.kt의 main 메서드 예시
fun main(args: Array<String>) {
    val password = "your-encryption-password" // 실제 암호화 비밀번호로 변경하세요

    // 암호화할 값
    val dbUrl = "jdbc:mysql://your-db-host:3306/your-db"
    val dbUsername = "your-username"
    val dbPassword = "your-password"

    // 값 암호화
    val encryptedDbUrl = encrypt(dbUrl, password)
    val encryptedDbUsername = encrypt(dbUsername, password)
    val encryptedDbPassword = encrypt(dbPassword, password)

    // 암호화된 값 출력
    println("Encrypted DB URL: ENC($encryptedDbUrl)")
    println("Encrypted DB Username: ENC($encryptedDbUsername)")
    println("Encrypted DB Password: ENC($encryptedDbPassword)")
}
```

### 3. 암호화된 값 사용하기

암호화된 값을 application-prod.yml 파일에 다음과 같이 사용할 수 있습니다:

```yaml
spring:
  datasource:
    url: ENC(암호화된_DB_URL)
    username: ENC(암호화된_사용자이름)
    password: ENC(암호화된_비밀번호)
```

또는 환경 변수를 사용하여 더 안전하게 관리할 수 있습니다:

```yaml
spring:
  datasource:
    url: ENC(${DB_URL:기본값})
    username: ENC(${DB_USERNAME:기본값})
    password: ENC(${DB_PASSWORD:기본값})
```

### 4. 애플리케이션 실행 시 암호화 비밀번호 설정

애플리케이션을 실행할 때 다음과 같이 암호화 비밀번호를 환경 변수로 설정해야 합니다:

```bash
# Windows
set JASYPT_ENCRYPTOR_PASSWORD=your-encryption-password
java -jar board-0.0.1-SNAPSHOT.jar

# Linux/Mac
export JASYPT_ENCRYPTOR_PASSWORD=your-encryption-password
java -jar board-0.0.1-SNAPSHOT.jar
```

### 5. GitHub Actions 또는 CI/CD 환경에서 사용하기

GitHub Actions 또는 다른 CI/CD 환경에서는 암호화 비밀번호와 데이터베이스 접속 정보를 시크릿으로 설정하고 환경 변수로 주입해야 합니다.

GitHub Actions 예시:

```yaml
name: Deploy

jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2

      # 다른 단계들...

      - name: Deploy to production
        env:
          JASYPT_ENCRYPTOR_PASSWORD: ${{ secrets.JASYPT_ENCRYPTOR_PASSWORD }}
          DB_URL: ${{ secrets.DB_URL }}
          DB_USERNAME: ${{ secrets.DB_USERNAME }}
          DB_PASSWORD: ${{ secrets.DB_PASSWORD }}
        run: |
          ./gradlew bootJar
          # 배포 명령어...
```

### 6. 주의사항

- 암호화 비밀번호는 절대 소스 코드나 GitHub 저장소에 포함되어서는 안 됩니다.
- 개발 환경과 운영 환경에서 서로 다른 암호화 비밀번호를 사용하는 것이 좋습니다.
- 암호화된 값이라도 GitHub에 공개되면 암호화 비밀번호가 노출될 위험이 있으므로, 가능하면 환경 변수를 사용하는 것이 더 안전합니다.
