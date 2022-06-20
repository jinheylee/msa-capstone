# 분석설계

- 호스트가 데이트 코스를 등록/수정/삭제한다.
- 고객이 데이트 코스에 대한 내용을 확인할 수 있다.
- 고객이 데이트 코스를 선택하여 북마크한다
- 고객이 마음에 드는 데이트 코스를 선택하여 좋아요(like)를 누른다.
- 고객이 좋아요(like)를 취소할 수 있다.
- 북마크가 되면 북마크한 내역(Message)이 전달된다.
- 고객이 북마크를 취소할 수 있다.
- 북마크가 취소될 경우 취소 내역(Message)이 전달된다.
- 고객이 데이트 코스에 대한 후기(review)를 남길 수 있다.
- 전체적인 데이트 코스에 대한 정보 및 후기 상태 등을 한 화면에서 확인 할 수 있다.(viewpage)


# SAGA Pattern

## 구현

서비스를 아래와 같은 방법으로 개별적으로 실행한다.

cd schedule
mvn spring-boot:run

cd communication
mvn spring-boot:run

cd review
mvn spring-boot:run

cd viewpage
mvn spring-boot:run

4개의 도메인으로 관리되고 있으며 코스관리(Schedule), 소통(Communication), 후기(Review), 코스조회(Viewpage)으로 구성된다.


# CQRS Pattern

### CQRS 패턴?

- CRUD에서 CUD(Command)와 R(Query)의 책임을 분리한 것이 CQRS 입니다.

## 구현

스케쥴(Schedule)의 리뷰 및 북마크 갯수 등 총 Status 에 대하여 고객(Customer)이 조회 할 수 있도록 CQRS 로 구현하였다.

- schedule, review, communication, message 개별 Aggregate Status 를 통합 조회하여 성능 Issue 를 사전에 예방할 수 있다.
- 비동기식으로 처리되어 발행된 이벤트 기반 Kafka 를 통해 수신/처리 되어 별도 Table 에 관리한다
- Table 모델링 (ROOMVIEW)

# Correlation / Compensation(Unique Key)



# Request / Response (Feign Client / Sync.Async)

### Feign Client 란?

1) Feign Client는 **web service 클라이언트를 보다 쉽게 작성할 수 있도록 도와줍니다.**

2) interface를 작성하고 annotation을 붙여주면 세부적인 내용 없이 사용할 수 있기 때문에 **코드 복잡도가 낮아집니다.**

3) **Netflix** 에서 만들어졌고, **spring-cloud-starter-openfeign** 으로 스프링 라이브러리에서 사용할 수 있습니다.

# Gateway



# Deploy / Pipeline



# Circuit Breaker



# Autoscale(HPA)



# Self-Healing(Liveness Probe)



# Zero-Downtime Deploy(Readiness Probe)



# Config Map / Persistence Volume



# Polyglot

