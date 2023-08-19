<공지사항>
dev : 가장 최근 파일입니다.
8.19 pm 6:51 ★★진주님 SignInActivity 수정했습니다 object UserListData를 SignInActivity내부로 옴겼어요★★


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


[FEAT] ⚙️ 8.18 pm 3.33
1.전체적 코드 수정, 
2.이메일(id)유효성검사 및 비밀번호 8자리 (숫자+영문) 유효성 검사 추가 , 
3. UserData.kt추가 UserDataList.kt추가

[fix]  🔧 8.18 3.45
SignInActivity : 아이디 > 이메일로 문구교체 

[fix]  🔧 8.18 3.51
SignInActivity ,SignUpActivity 잔잔바리 문구 수정

[fix]  🔧 SignUpActivity  8.18 4.08

1.비밀번호를 올바르게 입력하지 않아도 가입되는 버그 수정 

[fix]  🔧 activity_signup.xml 
8.18  4.26
가로모드시, 제일 아래 회원가입 버튼이 잘리는 오류 수정

[fix]  🔧 activity_signup.xml 
비밀번호 주의문구 수정 / 8자이상이라고 안씀 > 썼음 

[FEAT] ⚙️ 8.18 pm 4:40
1. 프로필사진클릭 시 다이얼로그 출력
2. 다이얼로그에 url입력 시 
3. 재대로된 url입력하면 이미지 바뀜
4. 잘 못된 url입력하면 에러이미지로 바뀜


[fix] 중복확인시, 이메일 형식이 아니면 , 가입불가 문구 수정 

[FEAT] : ⚙️ 8.18 pm 6:18
1. FriendEdit에서 프로필사진변경한 후 저장버튼을 누르면
2. MainActivity에서 FriendEdit로 들어갈떄 클릭했던 이미지버튼의 이미지 역시 FriendEdit에서 변경한 이미지로 바뀜
3. 다시 FriendEdit로 들어가면 변경했던 이미지가 그대로 유지됨.

[FIX] : 🔧 08.19 am 5:36
MainActivity, FriendEdit 
1.양쪽 왔다갔다 할때 프로필 사진 출력
2.초기 사진도 출력됨
3.프로필 사진 수정 기능 구현

[FEAT] : ⚙️ 8.19 am 05:50
1.MyPage: 이미지에서 MyPageDetail로 가게 만듬.
2.MyPage: 개인 정보 출력
3.MyPageDetail: text 정보를 MyPage로 옮기기 성공 하지만 Detail 페이지의 정보는 사라짐.
4.MyPage: 화면을 돌렸을때 개인 정보 창은 스크롤이 안된다. 2번째 contain은 밑에 힌색 부분이고 보라색 배경이 처음 배경이다.
5.MyPage: 프로필 사진이 변경이 되지 않는다.

[DESIGN] : 🎨 8.19 am 08:05
activity_main 게시판 프로필사진,이름,이미지,내용 추가

🔧 ⚙️🐛 : 8.19 pm 6:51 ★★진주님 SignInActivity 수정했습니다 object UserListData를 SignInActivity내부로 옴겼어요★★
FIX] : 🔧 뒤로가기 버튼 추가 //FIX] : 🐛 이미지버튼추가 형식 통일
FIX] : 🔧 MainActivity에서 MyPage,MyAbility로 넘어가는 버튼형식을 메뉴 팝업형태로 바꿈

[FEAT] : ⚙️ 8.19 pm 7:25
MyAbilityDetail페이지 ProgressBar 일부 수정

[CONFLICT] : 💥🚚 8.20 am 01:23
FIX] : 🔧 MainActivity 앞에서 받아온name표시,레이아웃조정
FIX] : 🔧 MyAbility 프로그래스 기능 구현 연동
1.MyAbility 에서 MyAbilityDetail로 들어가서 progressbar수정후
2.다시 MyAbility로 돌아왔을때 수정된 부분적용
3. 다시 MyAbilityDetail로 들어갔을때 역시 수정된부분 적용완료
4. 색깔부분 첨가

[FEAT] : ⚙️ 8.20 am 03:14
1. MyAbilityDetail 에서 작성하고 저장한 메모 MyAbility에 갔다가 돌아와도 유지 됨
2. MyAbilityDetail에서 메모를 저장하면 모든 프로젝트에 저장되어 공유하던 메모를
3. 각각 프로젝트에 메모를 개별 저장하게 수정함

[DESIGN] : 🎨 08.20 am 07:00
1. 1차적으로 버튼손보고 모든 레이아웃 색상 조금씩 변경

[FIX] : 🐛 08.20 am 08:09
1.FriendEdit에서 이미지를 변경하지않고 저장했을때 MainActivity에서 error이미지가 출력되던부분 수정
2.마찬가지로 다시 FriendEdit으로 돌아갔을때 error이미지가 출력되던부분 수정
