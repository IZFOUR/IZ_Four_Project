[PACK] : 🎁 08.14(16:15)
1. gitignore설정
2. 기본 Activity생성
3. SignUpActivity 기본적인부분만 코딩
4. activity_signup.xml 기본적인부분 디자인
5. String 기본적인 언어 추가
6. color색상 추가
7. theme의 parent(material -> AppCompat으로 수정, 내용추가)
 
[FEAT] : ⚙️ 08.14(17:20)
1.SignInActivity -> SignUp,Main 으로 이동하는 버튼만 추가
2.MyPageDetailActivity 추가

[FEAT] : ⚙️ 08.14(21:00)
1.activity_main.xml 디자인 초안
2.activity_main.xml 이미지 추가(해상도별)

[FEAT] : ⚙️ 08.15(06:15)
1.MyAbility 관련 Activitiy, xml 기본 초안
2.MyPage관련 Activity, xml 기본 초안

[FEAT] : ⚙️ 08.15(10:37)
MainActivity
1. 멤버추가 기능( 기존에 있던 이미지의 외각선 및 기타 옵션들 유지하면서 추가// xml연동)
2. 자잘한 xml수정
3.MainActivity에서 다른 액티비티로 넘어갈때 모두 적용
4.OtherPage -> Friend 액티비티 수정
5.FriendEditActivity 추가

[FEAT] : ⚙️8.16(15:12)
SighInActivity 
 1.스타일 추가 // 이미지사이즈 통일하는 거 themes.xml
 2.이미지 추가

 [FIX] : 🔧 8.16 15:28
 activity_signin.xml
 1. 코드 위치 수정

[!HOTFIX] : 💥 8.16 pm 03: 50 
**My_Page**: 이미지와 백버튼 수정 오류
이미지 크기 조정 오류
뒤로 가기 버튼 수정 오류
둘다 에뮬레이터에 적용이 안됨.

[FEAT] : ⚙️ 8.16 pm 04: 44
edittext_box.xml
edittext_box.xml
edittext_box_pressed.xml
edittext_selector.xml
로그인 / 비밀번호 입력창 박스 추가, 테두리 색변화 추가
로그인 박스 사이즈 조정

[FIX] : 🔧 8.16 pm 04: 50 
**My_page**: 프로필 아래의 정보 칸 수정 
에뮬레이터에서 보이는 정보칸 텍스트와 이미지 간격, 크기 조절

[FEAT] : ⚙️ 8.16 pm 05.32
MyAbility : 페이지 레이아웃 추가. 이후 각 프로젝트로 분산 및 ProgressBar 값 불러오는 기능 구현 필요
MyAbilityDetail : 팀A 프로젝트 레이아웃 추가. DetailNotepad 부분에 스크롤 기능 추가 및 텍스트 추가 기능 구현필요

[FEAT] : ⚙️ 8.16 pm.05:30
activity_friendedit.xml
1.디자인초안
2.뒤로가기 버튼

[FEAT] : ⚙️ MainActivity pm 10: 30
1. 데이터가 있는 4종류의 이미지버튼과
2. add버튼으로 추가되는 버튼 두종류 합침

[FIX] : 🔧  8.16 pm 10: 50 
**My_page**: MyPageEdit추가. 연동은 아직..
MypageDetail 구조 잡기. 이것도 아직 연동이 안됨.

[FEAT] : ⚙️ 8.17 am 04:00
1. MainActivity에서 이미지 클릭하면 해당 이미지와 관련된 데이터 출력
2. 그리고 이동한 FriendEdit에서 데이터 수정 후 상단 버튼누르면 데이터 저장완료
3. 멤버 우측에 플로팅액션바 눌러서 멤버추가 후 같은방식으로 데이터 추가후 상단 버튼누르면 데이터 저장됨.

[FEAT] : ⚙️8.17 10:00
1.이미지추가
2.회원가입 페이지 수정
3.회원가입 페이지 스크롤 바 추가
4.Gray 색상추가

[DESIGN] : 🎨 8.17 pm 05: 06
1. MyPage: 뒤로가기 버튼의 루프를 없앰, 편집 버튼을 없애고 추가 버튼을 만들어서 MyPageDetail과 연결 시킴.
2. MyPageDetail: 아직 디자인만 하고 데이터를 저장하지는 못함. 뒤로가기 버튼 활성화.

[FEAT] : ⚙️8.17 17:30
MyAbilityDetail 스크롤 기능 구현성공.  메모 추가 및 삭제기능 구현예정.  ProgressBar 관련 상호작용 고안중

FIX] : 🔧 08.17 18.27
MainActivity, FriendEdit 코드 최적화


[FEAT] : ⚙️ 8.17 pm7:39분
1. 로그인 / 회원가입 기능구현

[DESIGN] : 🎨 8.17 pm 10:22
1. MyPageEdit 디자인 추가

[FEAT] : ⚙️ 8.17 pm 10:45
1.MainActivity(가로모드 전체스크롤 기능)
2.FriendEdit(title,content 내용 추가,수정)

[FEAT] : ⚙️ 8.17 pm 11:30
1. MyAbilityDetail 기능추가
2. 실수로 메인에 머지했어요 :(

[FEAT] : ⚙️ 8.18 am 02:53
1. FriendEdit에서 플로팅버튼을 눌렀을떄 데이터 추가!
2. 현재 dev, main둘다 최신데이터인데 원래하던데로 아침에 pull은 dev를 땡기시고, push해서 pr하는건 dev에다가하세요. ( main은 놔두세요)

[FEAT] : ⚙️ 8.18 am 05:00
SignUpActivity 에서 회원가입할때 입력한 id,name,age,mbti를 MyPage까지 전달 Log.d 달아놨으니 확인

[FEAT] : ⚙️ 8.18 am 11:50
1. MyAbilityDetail 메모기능 추가
2. 메모가 늘어나게 만드는건 덜 만들어졌어요

[FEAT] : ⚙️ 8.18 pm 1:20
1. 반복된 코드 및 코드 간략화 user class추가 
