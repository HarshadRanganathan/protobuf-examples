package main

import (
	"fmt"
	"io/ioutil"
	"log"

	"github.com/golang/protobuf/jsonpb"
	"github.com/golang/protobuf/proto"
	complexpb "github.com/simple/src/complex"
	enumerationpb "github.com/simple/src/enumeration"
	simplepb "github.com/simple/src/simple"
)

func main() {
	fileDemo()

	jsonDemo()

	enumDemo()

	complexDemo()
}

func complexDemo() {
	cm := doComplex()
	fmt.Println(cm)
}

func enumDemo() {
	em := doEnum()
	fmt.Println(em)
}

func jsonDemo() {
	sm1 := doSimple()
	jsonString := toJson(sm1)
	fmt.Println(jsonString)

	sm2 := &simplepb.SimpleMessage{}
	fromJson(jsonString, sm2)
	fmt.Println(sm2)
}

func fileDemo() {
	sm1 := doSimple()

	writeToFile("simple.bin", sm1)

	sm2 := &simplepb.SimpleMessage{}
	readFromFile("simple.bin", sm2)
	fmt.Println(sm2)
}

func toJson(pb proto.Message) string {
	marshaller := jsonpb.Marshaler{}
	out, err := marshaller.MarshalToString(pb)
	if err != nil {
		log.Fatalln("Can't convert to JSON", err)
		return ""
	}
	return out
}

func fromJson(in string, pb proto.Message) {
	err := jsonpb.UnmarshalString(in, pb)
	if err != nil {
		log.Fatalln("Can't convert JSON to pb struct", err)
	}
}

func writeToFile(fname string, pb proto.Message) error {
	out, err := proto.Marshal(pb)
	if err != nil {
		log.Fatalln("Can't serialize to bytes", err)
		return err
	}

	if err := ioutil.WriteFile(fname, out, 0644); err != nil {
		log.Fatalln("Can't write to file", err)
		return err
	}

	log.Println("Data has been written to file")

	return nil
}

func readFromFile(fname string, pb proto.Message) error {
	in, err := ioutil.ReadFile(fname)

	if err != nil {
		log.Fatalln("Can't read from file")
		return err
	}

	if err := proto.Unmarshal(in, pb); err != nil {
		log.Fatalln("Couldn't put the bytes into the protocol buffers struct")
		return err
	}

	return nil
}

func doComplex() *complexpb.ComplexMessage {
	cm := complexpb.ComplexMessage{
		OneDummy: &complexpb.DummyMessage{
			Id:   1,
			Name: "First Message",
		},
		MultipleDummy: []*complexpb.DummyMessage{
			&complexpb.DummyMessage{
				Id:   2,
				Name: "Second Message",
			},
			&complexpb.DummyMessage{
				Id:   3,
				Name: "Third Message",
			},
		},
	}
	return &cm
}

func doEnum() *enumerationpb.EnumMessage {
	em := enumerationpb.EnumMessage{
		Id:           42,
		DayOfTheWeek: enumerationpb.DayOfTheWeek_FRIDAY,
	}
	return &em
}

func doSimple() *simplepb.SimpleMessage {
	sm := simplepb.SimpleMessage{
		Id:         12345,
		IsSimple:   true,
		Name:       "My Simple Message",
		SampleList: []int32{1, 2, 3, 4},
	}
	return &sm
}
