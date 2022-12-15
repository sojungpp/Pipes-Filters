# 💙 Pipes and Filters

해당 프로그램은 pipes and filters 패턴의 프로그램으로,  
source에 데이터를 넣어 파이프를 통해 필터를 거쳐 원하는 형태의 데이터를 sink를 통해 얻는 기법이다.
<br>
<br>

## 🔎 UML Diagram
![image](https://user-images.githubusercontent.com/90022940/207901987-feb1d2d4-90e6-46a6-ba06-95c22f2b472f.png)
<br>
<br>

## 🔎 Sequence Diagram
<details>
<summary>수강 신청</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207902349-3a12c78e-4024-4b40-80c3-f1995cdf070c.png"/>
<br>
</details>
<br>

## 🙂 Advantage

#### 1. 필터 재사용성 및 높은 유연성
필터는 입력 데이터를 가공해 출력하는 역할이므로 재사용 할 수 있다.  
원하는 대로 필터를 조합해 사용할 수 있어 높은 유연성을 가진다.

#### 2. 빠른 응답 속도 및 성능 향상 
하나의 프로세스에서 동시에 여러 쓰레드가 작동하는 멀티 쓰레드 프로그램, 요청과 응답 없이 이루어져 보다 빠른 응답 속도
<br><br>
## ☹ Disadvantage

#### 1. 어려운 디버깅
별도의 요청과 응답 없이 파이프 흐름에 따라 데이터가 가공되기 때문에,  
에러가 발생했을 때 잘못된 부분을 디버깅해 찾기 어렵다.

#### 2. 처리 시간 증가
쓰레드 간 동일한 데이터를 공유 시, 동시에 데이터를 가공하지 않도록 하는 동기화, 필터 간의 데이터 전송 시간,  
많은 쓰레드 동시 실행 시 일시적으로 중지되는 시간(context switching)으로 처리 시간이 증가할 수 있다.
