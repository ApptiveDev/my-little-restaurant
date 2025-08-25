# 현지 맛집 인증 기반 어플

## 📌 개요 / 프로젝트 소개

- **문제의식**: SNS·블로그 광고성 리뷰가 넘쳐나서, 여행자와 신규 거주자가 **진짜 로컬 맛집**을 찾기 힘듦.
- **해결방법**:
  - **위치/방문 인증(체크인)** 으로 가짜 리뷰 걸러내기
  - **현지인 가중치**(해당 구/동 누적 체크인, 재방문 수 등)로 추천 점수 계산
  - **짧고 신뢰도 높은 리뷰 포맷**(사진 + 한줄평 + 태그)
- **핵심가치**: 진정성, 간결함, 커뮤니티 신뢰
- **팀/배경**: Apptive 동아리 2025 아이디어톤 팀 프로젝트

---

## 📝 주요 기능

- **현지 인증 시스템**
  - GPS 기반 **체크인**(가짜 위치 방지, 일정 반경+시간 조건)
  - **재방문 뱃지**: 2·5·10회 방문 시 단계 뱃지 지급
  - **영수증/결제내역 선택적 업로드**(개인정보 마스킹 가이드)

- **추천 & 랭킹**
  - **현지인 가중치**: 해당 지역 체류/체크인 이력 많은 사용자 가중
  - **재방문 지수**: 같은 매장 재방문·체류시간 반영
  - **시각·요일별 핫플**: 점심/저녁, 평일/주말 랭킹 분리

- **리뷰·콘텐츠**
  - **3요소 리뷰**: 사진(최대 3장) + 50자 한줄평 + 태그(맛/분위기/가격)
  - **광고 라벨링**: 협찬·초대석 표기 의무(ON/OFF 불가)
  - **키워드 필터**: `#혼밥` `#단체` `#가성비` `#오마카세` 등

- **지도로 탐색**
  - 현재 위치/관심 지역 기반 **지도 클러스터링**
  - **필터**(카테고리, 가격대, 영업중, 혼잡도 베타), **정렬**(가까운순/현지인추천순)

- **신뢰도 관리**
  - **신뢰 점수(Trust Score)**: 체크인 진위, 리뷰 신고 이력, 계정 연령 반영
  - **리뷰 신고/판별**: 중복 사진, 과도한 홍보성 문구 자동 탐지(Beta)

- **소셜**
  - **팔로우 & 피드**: 내가 팔로우한 현지인의 최근 체크인/리뷰
  - **리스트 공유**: “부산 서면 점심 10선” 같은 컬렉션 공유

- **기타**
  - **오프라인 저장**(지도 타일·최근 본 가게 캐시)
  - **다크모드**, **한·영 지원(EN 베타)**

<!-- 
(백엔드, 프론트, 협업에 사용한 툴, 라이브러리, 프레임워크)

기술스택 배지 추가하는 방법 
1. https://simpleicons.org/ 에서 기술스택명 검색
2. 기술스택의 로고, 컬러 HEX 코드를 아래와 같이 입력
  - https://img.shields.io/badge/<표시될 이름>-<컬러 HEX>?style=for-the-badge&logo=<로고명>
3. 해당 URL로 마크다운 이미지 첨부
  - ![이미지명](URL) 형식
-->

(백엔드, 프론트, 협업에 사용한 툴, 라이브러리, 프레임워크)

![intellij](https://img.shields.io/badge/intellij_idea-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![vscode](https://img.shields.io/badge/vscode-000000?style=for-the-badge&logo=vscode&logoColor=white)
![androidstudio](https://img.shields.io/badge/android_studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)  

![docker](https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![nginx](https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)
![redis](https://img.shields.io/badge/redis-FF4438?style=for-the-badge&logo=redis&logoColor=white)
![github-action](https://img.shields.io/badge/github_actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)

![react](https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=white)
![jetpack-compose](https://img.shields.io/badge/jetpack_compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![spring](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

| 스택 | 설명 | 용도 |
|-----|-----|-----|
| Kotlin | 프론트엔드 | 안드로이드 및 IOS 프론트 제작 |
| Spring | 백엔드 | 안드로이드 및 IOS 백엔트 제작 |
| ... | ... | ... |

 ## 🖼️ 스크린샷

 ## 🤝 개발협업
 ### 🌲 Branch 
```
main ------- backend/<이름>/(<이슈번호>-)<작업명>    (백엔드 작업)
     \------ frontend/<이름>/(<이슈번호>-)<작업명>   (프론트 작업)

ex) backend/wonseok/#10-add-animation
ex) frontend/wonseok/fix-login-not-allowed   (이슈가 없으면)
```
브랜치 관리 전략은 `main`과 개인 브랜치만이 존재하는 간단한 Github Flow를 따릅니다.
- `main` 브랜치는 항상 작동 가능한 안정된 상태여야 한다.
  - 직접 커밋하지 않으며, Pull Request만으로 변경한다.
- 개인 브랜치에서 작업을 진행한다.
- 브랜치명은 작업 내용과 직군이 구체적으로 드러나도록 한다.
  - 브랜치명에 `backend`, `frontend`를 구분한다.
  - 띄어쓰기는 하이픈(`-`)으로 구분한다.
  - 브랜치명은 전부 소문자를 사용한다.

프로젝트에 CI/CD를 구성하는 등 규모가 커지면 `develop` 브랜치를 추가하거나 `git flow`로 전환할 수 있습니다. 

 ### 🍪 Pull Request
```
main    ---●---●---●---------● abc (Squash Merge)
                \           /
개인브랜치          a---b---c   ('abc' 합쳐진 하나의 커밋으로 병합)

PR 제목: [Backend/Frontend] <이슈번호> <작업명>
ex) [Backend] #10 프로필 화면에서 로그인 불가하던 문제 해결
ex) [Backend] 프로필 화면에서 로그인 불가하던 문제 해결     (이슈가 없으면)
```
`main` 브랜치의 커밋은 Pull Request 단위로 쌓으며 이를 위해 **Squash Merge**를 원칙으로 합니다. **Squash Merge**는 브랜치가 병합될 때 커밋들이 PR 제목으로 합쳐지게 됩니다. 커밋은 개인마다 기준이 조금씩 다른 반면, PR/브랜치는 이슈 단위로 생성하므로 일관된 기준으로 커밋을 쌓을 수 있어 히스토리 추적을 용이하게 합니다.
- 커밋 제목은 **PR 제목**으로 한다.
    - Backend/Frontend를 구분한다.
    - 작업 내용을 구체적으로 드러나게 적는다.
- 커밋 내용은 **PR 내용**으로 한다.
    - 브랜치에서의 변경점을 상세히 적는다.
- Pull Request는 작은 작업 단위(200줄 이내 권장)로 한다.

 ## 🛠 설치방법
(다른 개발자가 이 프로젝트를 테스트해볼 수 있도록 프론트, 백엔드 설치/실행 절차 안내)

### 💻 Frontend

### 💻 Backend

 ## 🧑‍💻 팀원
| <img width="100" src="https://github.com/cotidie.png"> | <img width="100" src="https://github.com/github.png"> | <img width="100" src="https://github.com/github.png"> | <img width="100" src="https://github.com/github.png"> | <img width="100" src="https://github.com/github.png"> | <img width="100" src="https://github.com/github.png"> | 
|:----------------------:|:----------------------:|:----------------------:|:----------------------:|:----------------------:|:----------------------:|
| [이도원](https://github.com/cotidie) | [양혜송](https://github.com/cotidie) | [이병찬](https://github.com/cotidie) | [이예람](https://github.com/cotidie) | [이가현](https://github.com/cotidie) | [김세엽](https://github.com/cotidie) |
| 💻 기획자 | 💻 디자이너 | 💻 프론트엔드 | 💻 프론트엔드 | 💻 백엔드 | ⛹️ 백엔드 |
| 23기 | 22기 | 22기 | 22기 | 21기 | 21기 |

 
