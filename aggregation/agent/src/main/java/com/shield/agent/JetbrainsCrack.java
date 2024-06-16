package com.shield.agent;


import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @author miller
 * @since 2023/9/26
 * @version 1.0.0
 */
public class JetbrainsCrack {
    public static void premain(String args, Instrumentation inst) {
//        inst.addTransformer();
    }

    static class MethodEntryTransformer implements ClassFileTransformer {
        private Log log = LogFactory.get();

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
           try {
               if(className.equals("com/jetbrains/ls/newLicenses/DecodeCertificates")){
               }
           }catch (Exception e){

           }
            return ClassFileTransformer.super.transform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer);
        }

        public static void main(String[] args) {

        }
    }
}
