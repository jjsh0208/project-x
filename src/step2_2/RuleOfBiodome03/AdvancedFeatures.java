package step2_2.RuleOfBiodome03;

//고급 기기
interface  AdvancedFeatures{ //스마트 기기만 기기를 활성화하기 때문에 SRP 위반 할 수도있다 따로 분리해서 사용
    void activateFeature(); //기기 활성화
}