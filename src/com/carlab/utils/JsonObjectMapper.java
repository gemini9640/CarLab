//package com.carlab.utils;
//
//import org.codehaus.jackson.map.ObjectMapper;
//
//public class JsonObjectMapper extends ObjectMapper{
//	public JsonObjectMapper() {
//        super();
//        // 空值处理为空串
//        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
//                jg.writeString("");
//            }
//        });
//    }
//}
