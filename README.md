# کاربرد عملی الگوهای طراحی شئ‌گرا (Object Oriented Design Patterns)

## اعضای گروه

نگار نوبختی - 98171201

پریمهر مرصع‌فر - 00000000

## توضیحات آزمایش

- روش ارسال

  - strategy

    context: package
    strategy reference: ship method
    ship method:
    (standard, express)
    execute: should ship package
    main:
    create context
    set ship method in every loop until package sent

- وضعیت بسته

  - state
    state: package delivery
    prop: package
    actions:
    toString
    send package

        concrete states:
            in-transit
                toString:
                    print "package in transit"
                sendPackage:
                    print "delivering package"
                    package.changeState(delivered);

            delivered
                print "package delivered"
                sendPackage:
                    do nothing

- package
  package weight
  ship method
  state (initial in-transit)

  setShipMethod(method);

  changeState(newState);

  sendPackage() {
  state.sendPackage();
  }

- main

  createPackage(weight)
  while (true)
  set ship method
  set state
  print package state (package.state.toString())
  if (sent)
  break
