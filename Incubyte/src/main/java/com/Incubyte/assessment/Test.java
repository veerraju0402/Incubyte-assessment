package com.Incubyte.assessment;

public class Test {

	public static void main(String[] args) {

		//Excpected response

		//System.out.println(add("-1\n2,3")); //Received negatives:-1
		//System.out.println(add("1\n-2,3")); //Received negatives:-2
		//System.out.println(add("-1\n-2,-3")); //Received negatives:1-2-3
		//System.out.println(add("1\n2,3"));   //total sum:6
		//System.out.println(add("//;\n1;2"));  //total sum:3
		//System.out.println(add("//;\n1;-2"));  //Received negatives:-2
		//System.out.println(add("//;\n-1;2"));   //Received negatives:-1
		System.out.println(add("//;\n-1;-2"));   //Received negatives:-1-2
	}

	public static String add(String numbers){
		Boolean flag=true;
		int sum=0;
		String neg="";
		String[] temp1=numbers.split(",");
		String[] s1=temp1;

		for(int j=0;j<temp1.length;j++){

			if(!s1[j].isEmpty() && ( s1[j].contains(";") ||  s1[j].contains("\n"))){
				String[] temp=s1[j].split(";");

				for(int f=0;f<temp.length;f++){

					if(temp[f].contains("\n")){
						String[] temp2=temp[f].split("\n");

						for(int l=0;l<temp2.length;l++){
							try{
								int x=Integer.parseInt(temp2[l]);
								if(x<0){
									neg+=x;
									throw new Exception();
								}else
									sum=sum+x;
							}catch(NumberFormatException e){

							}
							catch(Exception e){
								flag=false;
								sum=0;
							}
						}
					}else{
						try{
							int x=Integer.parseInt(temp[f]);
							if(x<0){
								neg+=x;
								throw new Exception();
							}else
								sum=sum+x;
						}catch(NumberFormatException e){

						}catch(Exception e){
							flag=false;
							sum=0;
						}
					}
				}

			}
			try{
				int x=Integer.parseInt(temp1[j]);
				if(x<0){
					neg+=x;
					throw new Exception();
				}else
					sum=sum+x;
			}catch(NumberFormatException e){

			}catch(Exception e){
				flag=false;
				sum=0;
			}
		}

		if(flag)
			return "total sum:"+sum;
		else
			return "Received negatives:"+neg;

	}

	public static String[] joinarrays(String[] s1,String[] s2){

		String[] masterArray=new String[s1.length+s2.length];
		for(int i=0;i<s1.length;i++){
			masterArray[i]=s1[i];
		}
		int k=s1.length;

		for(int i=k;i<k+s2.length;i++){
			masterArray[i]=s2[i-k];
		}
		return masterArray;
	}

}
