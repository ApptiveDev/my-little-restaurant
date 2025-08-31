# Android

## 목차

- [개발환경](#개발환경)
- [컨벤션](#컨벤션)
  - [코드 스타일](#코드-스타일)
  - [폴더 구조](#폴더-구조)
  - [브랜치 전략](#브랜치-전략)
  - [커밋 메시지](#커밋-메시지)
  - [PR 규칙](#pr-규칙)
- [포맷터 & 정적분석](#포맷터--정적분석)
- [워크플로우 예시](#워크플로우-예시)


## 개발환경
- Android Studio: **2025.1.2**
- Android SDK:
  - `compileSdk`: **36**
  - `minSdk`: **33**
  - `targetSdk`: **36**
  - `buildToolsVersion`: **33.0.1**
- Gradle: (프로젝트에 맞는 Gradle 버전 명시)
- Java:
  - `sourceCompatibility`: **11**
  - `targetCompatibility`: **11**
- Kotlin:
  - `kotlin.jvmTarget`: **11**
- 앱 버전:
  - `versionCode`: **1**
  - `versionName`: **1.0**

## 컨벤션

### 코드 스타일
- 클래스/파일: `PascalCase` (Ex: `MainActivity.kt`)
- 변수/함수: `camelCase`
- 상수: `UPPER_SNAKE_CASE`
- 라인 길이: **120자 권장**
- 함수 길이/복잡도: 한 함수는 한 책임(간단 유지), 복잡도 높으면 분리 권장
- 주석:
  - 공개 API/복잡 로직은 `KDoc` 사용
  - TODO: `// TODO: (이름) - 내용` 형식
- Null 처리: Kotlin nullable 타입과 `?:`, `let`, `run` 등 관용구 사용 권장

### 폴더 구조
```
app/
├── data/
├── domain/
├── ui/
├── di/
├── utils/
├── navigation/
├── build.gradle
└── ...

```

### 브랜치 전략
- `main` : 항상 배포 가능한 상태 (protected)
- `dev` : 통합 개발 브랜치
- 브랜치 네이밍(권장):
  - `android/feat/123`
  - `android/refactor/123`
  - `android/fix/123`

### 커밋 메시지


- `feat`: 새로운 기능
- `fix`: 버그 수정
- `docs`: 문서 변경
- `style`: 코드 포맷팅(로직 변경 없음)
- `refactor`: 리팩터 (기능 변화 없음)
- `test`: 테스트 추가/수정
- `chore`: 빌드/설정 변경
- 제목: 50자 이내, 끝에 마침표 금지


### PR 규칙
- Reviewer: 최소 1명 (main 대상으로는 2명 권장)
- PR 제목: `[type] scope: 간단요약` (Ex: `[feat] login: 카카오 로그인 추가`)
- PR 본문에 반드시 포함:
  - 변경 요약
  - 관련 이슈 번호
  - 테스트 및 검증 방법 (로컬에서 확인하는 절차)
- 병합 조건:
  - CI 통과 (build, ktlint/spotless 검증, detekt, unit tests)
  - 승인(Approvals) 충족
  - conflict 없음
- Merge 방식: 팀 합의 (권장: `Squash and merge`)

#### PR 체크리스트(복사해서 사용)
- [ ] 코드 빌드 성공
- [ ] ktlint / spotless 통과
- [ ] Detekt / Android Lint 통과
- [ ] Unit tests 통과 (가능 시)
- [ ] 동작 확인(간단한 재현 절차 기재)
- [ ] Reviewer 지정 및 승인

---

## 포맷터 & 정적분석
- 포맷터: **ktlint + spotless**
- 정적분석: **Detekt**, Android Lint
- 권장 설정: CI에서 `./gradlew spotlessCheck ktlintCheck detekt lint test` 등을 실행해 머지 전 검사
- 로컬 훅: `pre-commit` 또는 Gradle task로 `spotlessApply` 자동 실행 권장


