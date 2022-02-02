# Exception Handler 

This module is  about Restful api with exeption handler anotations like @NotNull, @Pattern, @Min, @Max etc. 

Firstly you should look in pom.xml file. As you see, the most important dependency is sprinboot validation dependency. 

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

Secondly I integrated lombok to dependencies cause it comes with some easy concepts. 

	    <dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>

Finally for Rest api I added springboot web dependency. 

        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

As you can see our data model is Bread.java under the entity folder. As I mentioned above our validation anotations are using in the model.
(@NotNull, @Min, @Pattern etc.)

This way the Bread object will be validated on each request.  

@Valid anotation must be in the ExcepteionController.class that is using @RestController before @RequestBody anotation. 

    @GetMapping("/getBread")
    public ResponseEntity<String> getBread(@Valid @RequestBody Bread bread)

    @PostMapping("/setBread")
    public ResponseEntity<Bread> setBread(@Valid @RequestBody Bread bread)

And in the same class you should integrate *@ExceptionHandler(value=MethodArgumentNotValidException.class) that will handle about when MethodArgumentNotValidException come to your service.
If you did not use this anotation, your response will be like;

    {
        "timestamp": "2022-02-02T23:23:02.945+00:00",
        "status": 400,
        "error": "Bad Request",
        "path": "/getBread"
    }

With @ExeptionHandler anotation your response like;
    
    "errorMessage": [
        {
            "fieldName": "size",
            "rejectedValue": null,
            "messageError": "bread size is not valid"
        }
    ]

At the configuration folder, I integrated MessageSource configuration and path to bread-message.properties file. 

      @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("bread-messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        return sessionLocaleResolver;
    }

bread-messages.properties ;

    bread.size = bread size is not valid
    bread.type = Must be either A, B or C

